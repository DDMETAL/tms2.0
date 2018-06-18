package product.dao;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import com.dmetal.tms.attachement.dao.AttachementDAO;
import com.dmetal.tms.attachement.entity.Attachement;

import common.dao.TestBaseDAO;

public class TestAttachementDAO extends TestBaseDAO{
	
	@Test
	public void testInsertObject() {
		AttachementDAO dao=(AttachementDAO)ac.getBean("attachementDAO");
		Attachement t=new Attachement();
		t.setTitle("titleB");
		t.setFileName("b.png");
		t.setFilePath("/upload/2018/05/23/B.png");
		t.setContentType("images/png");
		String fileContent="helloWorld";
		String digest=DigestUtils.md5Hex(fileContent.getBytes());
		t.setFileDisgest(digest);
		t.setCreatedUser("DMETAL");
		t.setModifiedUser("DMETAL");
		int rows=dao.insertObject(t);
		Assert.assertEquals(1, rows);
		
	}
}
