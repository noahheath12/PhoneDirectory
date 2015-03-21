package com.noahheath.howardu.assignments;

import java.util.*;
import java.io.*;

public class PhoneDirectory {
	private Map<String, String>directoryMap = new HashMap<String, String>();
	public boolean changedStatus;
	
	/**
	 * Reads a directory from a text file and populates a hash map with entries from the file.
	 */
	public PhoneDirectory()
	{
		File file = new File("src/Files/directory.txt");
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				String[] directory = line.split(",");
				directory[0] = directory[0].trim();
				directory[1] = directory[1].trim() + "\n";
				directoryMap.put(directory[0], directory[1]);
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			System.err.println("File not found");
		}
	}
	/**
	 * Return a phone number based on string personName
	 */
	public String lookup(String personName)
	
	{
			personName = directoryMap.get(personName);
			return personName;
	}
	/**
	 * Returns true if name is in the map.
	 * False if not
	 */
	public boolean findName(String personName)
	{
		if(!directoryMap.containsKey(personName))
			return false;
		else
			return true;
	}
	
	/**
	 * Creates a new value in the Hash Map
	 */
	public void AddOrChangeEntry(String personName, String phoneNumber)
	{
			directoryMap.put(personName, phoneNumber);
			changedStatus = true;
	}
	/**
	 * deletes an entry in the map
	 */
	public void deleteEntry(String name)
	{
		directoryMap.remove(name);
		changedStatus = true;
	}
	/**
	 * Writes the map to the file
	 */
	public void write() throws IOException
	{
		File outfile = new File("src/Files/directory.txt");
		FileWriter fWriter= null;
		fWriter = new FileWriter(outfile);
		Iterator<String> keyIterator = directoryMap.keySet().iterator();
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			fWriter.write(key + ", " + directoryMap.get(key));
		}
		fWriter.close();
	}
}
