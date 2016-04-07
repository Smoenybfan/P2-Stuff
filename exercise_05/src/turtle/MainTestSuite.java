package turtle;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ProgramParserTest.class,
	BoardTest.class,
	RepeatCommandTest.class
})
public class MainTestSuite {

}
