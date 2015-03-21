# PhoneDirectory
Large Scale Programming Lab 4

Lab 4: Phone Directory Implementation

A PhoneDirectory holds a list of names and associated phone numbers. But a phone directory is pretty useless unless the data in the directory can be saved permanently -- that is, in a file. Write a phone directory program that keeps its list of names and phone numbers in a file. The user of the program should be able to look up a name in the directory to find the associated phone number. For simplicity, a person is only allowed to have one number. The user should also be able to make changes to the data in the directory. Every time the program starts up, it should read the data from the file. Before the program terminates, if the data has been changed while the program was running, the file should be re-written with the new data.
Your PhoneDirectory class should have the following API:
1.	Look up a phone number        
2.	Add an entry to the directory        
3.	Delete an entry from the directory        
4.	Change someone's phone number   
5.	Write contents of phone directory to a file 

In other words, the skeleton of your class should be …

	class PhoneDirectory {
		private Map<String, String> directoryMap = new HashMap<String, String>();

		// local variable declarations and methods …

		public PhoneDirectory() {
		    // read file from some default location of your choosing
		}
    		public PhoneDirectory(String phoneDirectoyFile) {
		    // read file and create in memory phone directory
		}
		public String lookup(String personName) {
		    // return phone number based on name
		}
		public void addorChangeEntry(String name, String phoneNumber) {
		     // if the name is already in the directory add it else replace existing
     		     // name with the new phone Number
		}
		public void deleteEntry(String name) {
		     // Remove entry from the phone book associate with “name”
		}
		public void write() {
		     // write contents of in memory phone directory to a file.
     // research the web to see examples of how to iterate through a 
     // HashMap
		}
	}

One item we haven’t covered in class is the HashMap declared above.  A java HashMap is basically an implementation of a hash table that you will use to store your name, value pairs (name, phone number).

	For example,
	// Associate a phone number with a person
	directoryMap.put(“Barack Obama”, “111-222-4444”);
	…
	// Return a phone number with a specified key (Barack Obama)
	String phoneEntry = directoryMap.get(“Barack Obama”);

Another thing not covered is I/O.  Once again I suggest you research examples.  One recommendation is to use the java Scanner class to open and read a file.  The Scanner class will read one line of input at a time.  Your file will probably look like …

	Barack Obama, 111-222-4444
	Michelle Obama, 222-333-5555
	etc., etc.	

Research output to a file on your own.

In order to populate your directoryMap you will have to split each line of input to get a name and phone number.  An easy way to do this is to use the split method on the java String object.  For example

	Read input line from Scanner into a String object, i.e., inputLine
	String [] namePhone = inputLine.split(“,”);
	namePhone[0] = namePhone[0].trim();  // remove trailing/leading spaces
	namePhone[1] = namePhone[1].trim();  // remove trailing/leading spaces
 	etc., etc.

Once executed, namePhone[0] will contain “Barack Obama”, namePhone[1] contains “111-222-4444”.  Clearly you will need to process in some sort of loop for each line of input read.		
		
Deliverables:
Create a Java project in Eclipse for this assignment zip it up and e-mail to me as in previous assignments.
Your submission will be evaluated on correctness (satisfying the requirements), error handling, code readability (i.e., java docs) and robustness of your Driver (showing me that your program works reasonably well).  

