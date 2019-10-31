package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.revature.util.SecurityUtil;

/**
 * Contains all tests used against <code>SecurityUtil.java</code>.
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SecurityTest {
	private SecurityUtil su = new SecurityUtil();
	
	/**
	 * Ensure the <code>hashSha256()</code> method generates a proper hash.<br>
	 * A comparison to the word <b>password</b> will be made.
	 * It will be hashed, and compared to its SHA-256 equivalent.
	 */
	@Test
	public void A_ReturnHashWithNoSalt() {
		String hash = su.hashSha256("password", "");
		assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", hash);
	}
	
	/**
	 * Ensure the <code>hashSha256()</code> method generates a proper hash.<br>
	 * A comparison to the word <b>TheNaN2091!</b> will be made.
	 * It will be hashed, and compared to its SHA-256 equivalent.
	 */
	@Test
	public void B_ReturnHashWithNoSalt() {
		String hash = su.hashSha256("TheNaN2091!", "");
		assertEquals("694931a13999da2fea6c51bb775545fb0c278ed837dfdf13ad04194f26604b5e", hash);
	}
	
	/**
	 * Ensure the <code>generateSalt()</code> method generates a fixed salt length.
	 */
	@Test
	public void C_GenerateFixedSalt() {
		String salt = su.generateSalt();
		assertEquals(32, salt.length());
	}
	
	/**
	 * Ensure that, when adding a salt to the same password, it is different every time.<br>
	 * For instance, if "<b>myPassword</b>" and a random salt gets hashed, and then the same process is
	 * repeated again (with a different salt), they should not match.
	 */
	@Test
	public void D_GenerateSaltAndAppendForHashing() {
		String hashA = su.hashSha256("myPassword", su.generateSalt());
		String hashB = su.hashSha256("myPassword", su.generateSalt());
		
		assertFalse(hashA.equals(hashB));
	}
}
