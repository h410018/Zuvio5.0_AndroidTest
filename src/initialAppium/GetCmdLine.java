package initialAppium;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetCmdLine {

	public static void run() {
		Runtime runtime = Runtime.getRuntime();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec("adb devices").getInputStream()));
			// StringBuffer b = new StringBuffer();
			String line = null;
			StringBuffer b = new StringBuffer();
			while ((line = br.readLine()) != null) {//�Y�U�@��!=null
				if(line.contains("	")) {
					b.append(line + "\n");
					break;
				}				
			}
			System.out.println(b.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetCmdLine get = new GetCmdLine();
		get.run();

	}

}
