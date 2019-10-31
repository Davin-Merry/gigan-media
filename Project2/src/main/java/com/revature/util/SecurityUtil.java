package com.revature.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Responsible for salting and hashing the passwords passed into its main method.<br>
 * 
 * @author Davin Merry
 *
 */
public class SecurityUtil {
	private static MessageDigest md;
	private static String saltChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	/**
	 * Converts any hashed String to its base-16 equivalent.
	 * 
	 * @param hash Byte array hash to convert
	 * @return The base-16 representation of hashed value (String)
	 */
	private static String shaHexRepresentation(byte[] hash) {
		//Convert byte array to signum representation
		BigInteger n = new BigInteger(1, hash);
		//Convert BigInteger to Base 16 string
		StringBuilder hexStr = new StringBuilder(n.toString(16));
		
		//If too short, pad remainder with 0s
		while (hexStr.length() < 32) {
			hexStr.insert(0, '0');
		}
		
		return hexStr.toString();
	}
	
	/**
	 * Generates a salt using <code>java.security.SecureRandom</code>.
	 * 
	 * @return The randomly generated salt of fixed length with
	 * the characters <code>A-Z</code>, <code>a-z</code>, and/or <code>0-9</code>.
	 */
	public String generateSalt() {
		//Creates a new SecureRandom number generator
		SecureRandom r = new SecureRandom();
		StringBuilder salt = new StringBuilder();
		
		//Per iteration, add a character by random position from saltChars
		for (int i = 0; i < 32; i++) {
			salt.append(saltChars.charAt(r.nextInt(saltChars.length())));
		}
		return salt.toString();
	}
	
	/**
	 * A function that will take in two <code>String</code> Objects and return a
	 * salted and hashed SHA-256 string as a result.<br><br>
	 * The first string (<code>str</code>) would be the plaintext.
	 * The second string (<code>salt</code>) would be the salt to attach.<br>
	 * If a <code>NoSuchAlgorithmException</code> occurs, returns <code>null</code>.
	 * 
	 * @param str The string to be hashed
	 * @param salt The salt to use for hashing
	 * @return The hashed hex string
	 */
	public String hashSha256(String str, String salt) {
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			//This should never catch, but just in case it does, return null.
			return null;
		}
		
		//Concatenate the plaintext with the salt
		str = str + salt;
		
		return shaHexRepresentation(md.digest(str.getBytes()));
	}
}