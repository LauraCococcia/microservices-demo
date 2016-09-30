package io.pivotal.microservices.services;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.springframework.boot.SpringApplication;

import io.pivotal.microservices.accounts.AccountsController;
import io.pivotal.microservices.services.accounts.AccountsServer;
import io.pivotal.microservices.services.categories.CategoriesServer;
import io.pivotal.microservices.services.items.ItemsServer;
import io.pivotal.microservices.services.login.LoginServer;
import io.pivotal.microservices.services.products.ProductsServer;
import io.pivotal.microservices.services.registration.RegistrationServer;
import io.pivotal.microservices.services.web.WebServer;

/**
 * Allow the servers to be invoke from the command-line. The jar is built with
 * this as the <code>Main-Class</code> in the jar's <code>MANIFEST.MF</code>.
 * 
 * @author Paul Chapman
 */
public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SocketException, ParseException {

		String eurekaIp = "172.20.10.251";
		String dbServer = "172.20.16.3";
		String maxThreads = "500";
		String serverPort;

		String serverName = "NO-VALUE";
		Logger logger = Logger.getLogger(AccountsController.class.getName());

		// default config
		System.setProperty("server.tomcat.max-threads", maxThreads);
		System.setProperty("spring.datasource.max-active", String.valueOf(Integer.valueOf(maxThreads) * 5));
		System.setProperty("spring.datasource.max-idle",
				String.valueOf((int) Math.ceil(Integer.valueOf(maxThreads) * 3 / 4)));
		System.setProperty("spring.datasource.max-wait", "60000");
		System.setProperty("spring.datasource.min-idle",
				String.valueOf((int) Math.ceil(Integer.valueOf(maxThreads) / 4)));

		System.setProperty("eureka.ip", eurekaIp);
		System.setProperty("datasource.url", dbServer);

		CommandLineParser cmdParser = new BasicParser();
		CommandLine cmd = cmdParser.parse(options(), args);

		if (cmd.hasOption("h")) {
			help();
		} else {
			if (cmd.hasOption("s")) {
				System.out.println(cmd.getOptionValue("s"));
				serverName = cmd.getOptionValue("s");
				System.out.println("serverName: " + serverName);
			}
			if (cmd.hasOption("e")) {
				System.out.println(cmd.getOptionValue("e"));
				eurekaIp = cmd.getOptionValue("e");
			}
			if (cmd.hasOption("t")) {
				System.out.println(cmd.getOptionValue("t"));
				maxThreads = cmd.getOptionValue("t");
			}
			if (cmd.hasOption("db")) {
				System.out.println(cmd.getOptionValue("db"));
				dbServer = cmd.getOptionValue("db");
			}
			if (cmd.hasOption("p")) {
				System.out.println(cmd.getOptionValue("p"));
				serverPort = cmd.getOptionValue("p");
			}

			// Tell server to look for <server-name>-server.properties or
			// <server-name>-server.yml (this app. uses YAML)
			System.setProperty("spring.config.name", serverName + "-server");

			// NetworkInterface iface = NetworkInterface.getByName("en4");
			Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
			InetAddress addr = null;
			while (ifaces.hasMoreElements()) {
				NetworkInterface iface = ifaces.nextElement();
				Enumeration<InetAddress> addresses = iface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					addr = addresses.nextElement();
					if (addr instanceof Inet4Address && !addr.isLoopbackAddress()
							&& (addr.toString().substring(1).startsWith("172.20")
									|| addr.toString().substring(1).startsWith("192.168.1")
									|| addr.toString().substring(1).startsWith("192.168.2"))) {
						// System.out.println(addr);
						System.setProperty("server.address", addr.toString().substring(1));
					}
				}
			}

			if (serverName.equals("registration")) {
				SpringApplication.run(RegistrationServer.class, args);
			} else if (serverName.equals("accounts")) {
				SpringApplication.run(AccountsServer.class, args);
			} else if (serverName.equals("products")) {
				SpringApplication.run(ProductsServer.class, args);
			} else if (serverName.equals("categories")) {
				SpringApplication.run(CategoriesServer.class, args);
			} else if (serverName.equals("items")) {
				SpringApplication.run(ItemsServer.class, args);
			} else if (serverName.equals("login")) {
				SpringApplication.run(LoginServer.class, args);
			} else if (serverName.equals("web")) {
				SpringApplication.run(WebServer.class, args);
			} else {
				System.out.println("Unknown server type: " + serverName);
				usage();
			}
		}
	}

	protected static void usage() {
		System.out.println("Usage: java -jar ... <server-name> [server-port]");
		System.out.println("     where server-name is 'registration', " + "'accounts' or 'web' and server-port > 1024");
	}

	public static Options options() {
		Options options = new Options();
		options.addOption("e", "eureka", true, "eureka server");
		options.addOption("db", "database", true, "database server");
		options.addOption("t", "maxThreads", true, "max threads");
		options.addOption("s", "serverName", true, "server name");
		options.addOption("p", "serverPort", true, "server port");
		options.addOption("h", "help", false, "help");
		return options;
	}

	public static void help() {
		System.out.println("e | eureka -> eureka server\n" + "db ! database -> database server\n"
				+ "t | maxThreads -> max threads\n" + "s | serverName -> server name\n"
				+ "p | serverPort -> server port\n" + "h | help -> help\n");
	}
}
