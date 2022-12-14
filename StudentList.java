import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
	public static String getlineFromFile() throws  Exception{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.STUDENTS_FILE_NAME)));
		String line = bufferedReader.readLine();
		return line;
	}
	public  static BufferedWriter getFileBufferedWriter() throws Exception{
		return new BufferedWriter(new FileWriter(Constants.STUDENTS_FILE_NAME, true));
	}

	public static void main(String[] args)
	{

		if(args.length != 1){
			System.err.println(Constants.MSG_INVALID_NUMBER_OF_ARGUMENTS);
			System.err.println(Constants.MSG_EXITING_PROGRAM);
			System.exit(1);
		}

//		Check arguments
		if(args[0].equals(Constants.ARG_LIST_DATA))
		{
			System.out.println(Constants.MSG_LOADING_DATA);
			try
			{

			String students[] = getlineFromFile().split(Constants.WORDS_SPLIT_REGEX);
			for(String student : students) { System.out.println(student);
			}
			}
			catch (Exception e){}
			System.out.println(Constants.MSG_LOADED_DATA);
		}
		else if(args[0].equals(Constants.ARG_SHOW_RANDOM_DATA))
		{
			System.out.println(Constants.MSG_LOADING_DATA);
			try
			{
			String students[] = getlineFromFile().split(Constants.WORDS_SPLIT_REGEX);

				int index =  new Random().nextInt();
					System.out.println(students[index]);
			}
			catch (Exception e){}
			System.out.println(Constants.MSG_LOADED_DATA);
		}
		else if(args[0].contains(Constants.ARG_ADD_DATA))
		{
			System.out.println(Constants.MSG_LOADING_DATA);
			try
			{
			BufferedWriter bufferedWriter = getFileBufferedWriter();
			String new_date = args[0].substring(1);


	        String formate_date=  new SimpleDateFormat(Constants.DATE_FORMAT_PATTERN ).format( new Date());
			bufferedWriter.write(Constants.WORDS_SPLIT_REGEX+new_date+Constants.MSG_DATA_UPDATED+formate_date);
			bufferedWriter.close();
			}
			catch (Exception e)
			{

			}
							
			System.out.println(Constants.MSG_LOADED_DATA);
		}
		else if(args[0].contains(Constants.ARG_FIND_DATA))
		{
			System.out.println(Constants.MSG_LOADING_DATA);
			try
			{
			String students[] = getlineFromFile().split(",");
			boolean done = false;

			for(int idx = 0; idx<students.length && !done; idx++)
			{
				if(students[idx].equals(args[0].substring(1) ))
				{
					System.out.println(Constants.MSG_DATA_FOUND);
						done=true;
				}
			}
			}
			catch (Exception e)
			{

			}
			System.out.println(Constants.MSG_LOADED_DATA);
		}
		else if(args[0].contains("c")) 
		{
			System.out.println(Constants.MSG_LOADING_DATA);
			try
			{
			
			char students[] = getlineFromFile().toCharArray();
			boolean in_word = false;
			int count=0;
			for(char student:students) {
				if(student ==' ')
				{
					if (!in_word)
					{
						count++; in_word =true;
					}
					else
					{
						in_word=false;
					}
				}
			}
			System.out.println(count +Constants.MSG_WORDS_FOUND);
			}
			catch (Exception e){}
			System.out.println(Constants.MSG_LOADED_DATA);
		}
		else{
			System.err.println(Constants.MSG_INVALID_ARGUMENTS);
			System.err.println(Constants.MSG_EXITING_PROGRAM);
			System.exit(2);
		}
	}
}