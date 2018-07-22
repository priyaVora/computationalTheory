import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import vora.priya.computationalTheory.Driver.Driver;
import vora.priya.computationalTheory.TuringMachine.TuringMachine;

public class CalculateTest {

	@Test
	public void TestThreeDigitAdditionWithTwo() {
		TuringMachine machine = new TuringMachine("");
		Driver driver = new Driver();
		driver.calculate(machine, "123+11");

		String answer = machine.getTape().getAnswer();
		System.out.println("Answer: " + answer);
		assertEquals("134", answer);
	}

	@Test
	public void TestThreeDigitAdditionWithOne() {
		TuringMachine machine = new TuringMachine("");
		Driver driver = new Driver();
		driver.calculate(machine, "99+1");

		String answer = machine.getTape().getAnswer();
		System.out.println("Answer: " + answer);
		assertEquals("100", answer);
	}

	@Test
	public void TestOneDigitAdditionWithOne() {
		TuringMachine machine = new TuringMachine("");
		Driver driver = new Driver();
		driver.calculate(machine, "1+1");

		String answer = machine.getTape().getAnswer();
		System.out.println("Answer: " + answer);
		assertEquals("2", answer);
	}

	@Test
	public void TestAdditionWithThreeDigits() {
		TuringMachine machine = new TuringMachine("");
		Driver driver = new Driver();
		driver.calculate(machine, "999+999");

		String answer = machine.getTape().getAnswer();
		System.out.println("Answer: " + answer);
		assertEquals("1998", answer);
	}

	@Test
	public void Test5() {
		TuringMachine machine = new TuringMachine("");
		Driver driver = new Driver();
		driver.calculate(machine, "55+55");

		String answer = machine.getTape().getAnswer();
		System.out.println("Answer: " + answer);
		assertEquals("110", answer);
	}

	@Test
	public void Test6() {
		TuringMachine machine = new TuringMachine("");
		Driver driver = new Driver();
		driver.calculate(machine, "1+123");

		String answer = machine.getTape().getAnswer();
		System.out.println("Answer: " + answer);
		assertEquals("124", answer);
	}

	@Test
	public void Test7() {
		TuringMachine machine = new TuringMachine("");
		Driver driver = new Driver();
		driver.calculate(machine, "23+23");

		String answer = machine.getTape().getAnswer();
		System.out.println("Answer: " + answer);
		assertEquals("46", answer);
	}

}
