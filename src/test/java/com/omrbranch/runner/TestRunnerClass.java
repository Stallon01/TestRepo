package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(name = {"Verifying Book Hotel page without including GST and otherRequest"},dryRun=false,publish=true,monochrome=true,plugin= {"pretty","json:target\\report.json"},snippets=SnippetType.CAMELCASE,glue="com.stepdefinition",features="D:\\Java Tasks\\JS Testing\\OmrBranchHotelBookingAutomation\\src\\test\\resources\\Features",stepNotifications=true)
public class TestRunnerClass {
	@AfterClass
	public static void afterClass() {
	Reporting.generateJvmReport("target\\report.json");
	
}
}

