package dev.codecounty.java.java8.advance.encryption.encryption_1;

import org.junit.Test;

import java.util.Base64;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EncryptUtilTest {

    /**
     * Tests for the `encrypt` method in the EncryptUtil class.
     * The method encrypts the provided input string using specified security key, key specification,
     * and algorithm, returning the encrypted result as a Base64 encoded byte array.
     */

    @Test
    public void testEncryptValidInput() {
        String input = "HelloWorld";
        String secKey = Base64.getEncoder().encodeToString("1234567890123456".getBytes());
        String secKeySpec = "AES";
        String algo = "AES/CBC/PKCS5Padding";

        byte[] result = EncryptUtil.encrypt(input, secKey, secKeySpec, algo);

        assertNotNull("Encryption result should not be null", result);
    }

    @Test
    public void testEncryptEmptyInput() {
        String input = "";
        String secKey = Base64.getEncoder().encodeToString("1234567890123456".getBytes());
        String secKeySpec = "AES";
        String algo = "AES/CBC/PKCS5Padding";

        byte[] result = EncryptUtil.encrypt(input, secKey, secKeySpec, algo);

        assertNotNull("Encryption result for empty input should not be null", result);
    }

    @Test
    public void testEncryptInvalidKey() {
        String input = "HelloWorld";
        String secKey = Base64.getEncoder().encodeToString("shortkey".getBytes()); // Invalid key length for AES
        String secKeySpec = "AES";
        String algo = "AES/CBC/PKCS5Padding";

        byte[] result = EncryptUtil.encrypt(input, secKey, secKeySpec, algo);

        assertNull("Encryption should fail for an invalid key", result);
    }

    @Test
    public void testEncryptInvalidAlgorithm() {
        String input = "HelloWorld";
        String secKey = Base64.getEncoder().encodeToString("1234567890123456".getBytes());
        String secKeySpec = "AES";
        String algo = "Invalid/Algorithm"; // Invalid algorithm

        byte[] result = EncryptUtil.encrypt(input, secKey, secKeySpec, algo);

        assertNull("Encryption should fail for an invalid algorithm", result);
    }

    @Test
    public void testEncryptNullInput() {
        String input = null;
        String secKey = Base64.getEncoder().encodeToString("1234567890123456".getBytes());
        String secKeySpec = "AES";
        String algo = "AES/CBC/PKCS5Padding";

        byte[] result = EncryptUtil.encrypt(input, secKey, secKeySpec, algo);

        assertNull("Encryption should fail for null input", result);
    }
}