package com.omrbranch.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	public static void generateJvmReport(String jsonFile) {
		File file = new File("D:\\Java Tasks\\JS Testing\\OmrBranchHotelBookingAutomation\\target");
		Configuration configuration = new Configuration(file,"OMR Branch Hotel Booking Automation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser Version", "107");
		configuration.addClassifications("OS", "Windows 11");
		configuration.addClassifications("Sprint", "24");
		ArrayList<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

		
	}
}
