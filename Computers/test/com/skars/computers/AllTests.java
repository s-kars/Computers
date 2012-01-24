package com.skars.computers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.skars.computers.dataservice.computer.ComputerDataServiceTest;
import com.skars.computers.model.ComputerPersistTest;
import com.skars.computers.model.HddPersistTest;
import com.skars.computers.model.KeyboardPersistTest;
import com.skars.computers.model.MonitorPersistTest;
import com.skars.computers.model.MotherboardPersistTest;
import com.skars.computers.model.MousePersistTest;
import com.skars.computers.model.ProcessorPersistTest;
import com.skars.computers.model.RamPersistTest;
import com.skars.computers.model.VideoCardPersistTest;

@RunWith(Suite.class)
@SuiteClasses({
	/* Model tests. */
	ProcessorPersistTest.class,
	MotherboardPersistTest.class,
	RamPersistTest.class,
	VideoCardPersistTest.class,
	HddPersistTest.class,
	MonitorPersistTest.class,
	KeyboardPersistTest.class,
	MousePersistTest.class,
	ComputerPersistTest.class,
	
	/* Data services tests. */
	ComputerDataServiceTest.class
})
public class AllTests {

}
