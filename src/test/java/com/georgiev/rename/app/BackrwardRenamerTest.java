package com.georgiev.rename.app;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class BackrwardRenamerTest {

	@Test
	public void shouldRenameFilesListTest() {
		String newFileName = "i";

		List<String> names = new ArrayList<String>();
		names.add("a1.pdf");
		names.add("a2.pdf");
		names.add("a3.pdf");
		names.add("a4.pdf");

		BackwardRenamer bRenamer = new BackwardRenamer(newFileName,names.size());
		Map<String, String> newFileNames = bRenamer.getNewFileNames(names);

		Assert.assertNotNull(newFileNames);
		Assert.assertEquals("i008.pdf", newFileNames.get("a1.pdf"));
		Assert.assertEquals("i006.pdf", newFileNames.get("a2.pdf"));
		Assert.assertEquals("i004.pdf", newFileNames.get("a3.pdf"));
		Assert.assertEquals("i002.pdf", newFileNames.get("a4.pdf"));

	}
}