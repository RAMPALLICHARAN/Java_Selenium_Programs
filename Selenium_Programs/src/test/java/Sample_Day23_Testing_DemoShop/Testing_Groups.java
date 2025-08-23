package Sample_Day23_Testing_DemoShop;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Testing_Groups {

	@Test(groups = {"smoke"})

	public void test1() {

		System.out.println("This is Test case 1");

	}

	@Ignore ("under development")
	@Test(groups = {"sanity"})

	public void test2() {

		System.out.println("This is Test case 2");

	}


	@Test(dependsOnGroups = {"smoke"})

	public void test3() {

		System.out.println("This is Test case 3");

	}

@Test(groups = {"smoke", "regression"})

	public void test4() {

		System.out.println("This is Test case 4");

	}

}


