package com.georgiev.rename.app;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ForwardRenamerTest {

	@Test
	public void shouldRenameFilesListTest() {
		String newFileName = "i";
		ForwardRenamer fRenamer = new ForwardRenamer(newFileName);
		List<String> names = new ArrayList<String>();
		names.add("a1.pdf");
		names.add("a2.pdf");
		names.add("a3.pdf");

		Map<String, String> newFileNames = fRenamer.getNewFileNames(names);

		Assert.assertNotNull(newFileNames);
		Assert.assertEquals("i001.pdf", newFileNames.get("a1.pdf"));
		Assert.assertEquals("i003.pdf", newFileNames.get("a2.pdf"));
		Assert.assertEquals("i005.pdf", newFileNames.get("a3.pdf"));

	}
}