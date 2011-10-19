package com.google.gwt.flowplayer.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateEvent {

	public static String defaultPackage = "com/google/gwt/flowplayer/client/event";

	public static void main(String args[]) {

		init();

	}

	private static void init() {
		System.out.print("Package de l'évènement (" + defaultPackage + ") : ");
		String pack = lireString();
		if (!pack.trim().equals(""))
			defaultPackage = pack;
		System.out.print("Nom de l'évènement : ");
		String eventName = lireString();
		System.out.print("Créer un package ? (Y/N) : ");
		boolean createPackage = lireCreatePackage();
		createFile(eventName, createPackage);
		System.out.println("Evènement " + eventName);
		init();
	}

	private static void createFile(String eventName, boolean createPackage) {
		String templatePackage = GenerateEvent.class.getPackage().getName().replaceAll("\\.", "/");
		String packageName = defaultPackage.replace('/', '.');
		File eventFile;
		if (createPackage) {
			packageName += "." + eventName.toLowerCase();
			File eventFolder = new File("./src/main/java/" + defaultPackage + "/" + eventName.toLowerCase());
			eventFolder.mkdirs();
			eventFile = new File("./src/main/java/" + defaultPackage + "/" + eventName.toLowerCase() + "/" + eventName
					+ "Event.java");
			if (!eventFile.isFile()) {
				try {
					eventFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			eventFile = new File("./src/main/java/" + defaultPackage + "/" + eventName + "Event.java");
			if (!eventFile.isFile()) {
				try {
					eventFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		File eventTpl = new File("./src/main/java/" + templatePackage + "/event.tpl");

		try {
			String strEvent = readFileAsString(eventTpl.getPath());

			strEvent = strEvent.replaceAll("##PACKAGE##", packageName);
			strEvent = strEvent.replaceAll("##Event##", eventName);

			BufferedWriter outEvent = new BufferedWriter(new FileWriter(eventFile));
			outEvent.write(strEvent);
			outEvent.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File handlerFile;
		if (createPackage) {
			handlerFile = new File("./src/main/java/" + defaultPackage + "/" + eventName.toLowerCase() + "/"
					+ eventName + "Handler.java");
			if (!handlerFile.isFile()) {
				try {
					handlerFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			handlerFile = new File("./src/main/java/" + defaultPackage + "/" + eventName + "Handler.java");
			if (!handlerFile.isFile()) {
				try {
					handlerFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		File handlerTpl = new File("./src/main/java/" + templatePackage + "/handler.tpl");

		System.out.println(handlerTpl.getPath());
		try {

			String strHandler = readFileAsString(handlerTpl.getPath());
			strHandler = strHandler.replaceAll("##PACKAGE##", packageName);
			strHandler = strHandler.replaceAll("##Event##", eventName);

			BufferedWriter outEvent = new BufferedWriter(new FileWriter(handlerFile));
			outEvent.write(strHandler);
			outEvent.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean lireCreatePackage() {
		String ligne_lue = null;
		try {
			InputStreamReader lecteur = new InputStreamReader(System.in);
			BufferedReader entree = new BufferedReader(lecteur);
			ligne_lue = entree.readLine();
		} catch (IOException err) {
			System.exit(0);
		}
		if (ligne_lue.toLowerCase().equals("y"))
			return true;

		return false;
	}

	public static String lireString() {
		String ligne_lue = null;
		try {
			InputStreamReader lecteur = new InputStreamReader(System.in);
			BufferedReader entree = new BufferedReader(lecteur);
			ligne_lue = entree.readLine();
		} catch (IOException err) {
			System.exit(0);
		}
		return ligne_lue;
	}

	private static String readFileAsString(String filePath) throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}
}
