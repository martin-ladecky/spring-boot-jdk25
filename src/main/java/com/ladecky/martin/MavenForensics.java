package com.ladecky.martin;

import org.sonatype.plexus.components.cipher.DefaultPlexusCipher;

public class MavenForensics {
    public static void main(String[] args) throws Exception {
        DefaultPlexusCipher cipher = new DefaultPlexusCipher();

        // 1. The Master Key from settings-security.xml
        String masterHash = "{T5VIm0EYWwIHpO8VtbJQ3KWTpOBxKLFtVXLWqV6Vop3sO4fJoOqDXJoUQreeGLai}";

        // 2. The Server Password from settings.xml
        String serverHash = "{QG7YUq6ORssHkqkQjhAHxd1KXFc84/gnpPZngq9zTl4nvLLM3Za9+GN9M4BySNdg}";

        // Forensic Step: Decrypting the Master Hash to get the usable key
        // Maven uses the hardcoded salt "settings.security"
        String masterPassphrase = cipher.decryptDecorated(masterHash, "settings.security");

        // Forensic Step: Using that key to decrypt the actual Artifactory password
        String plaintext = cipher.decryptDecorated(serverHash, masterPassphrase);

        System.out.println("🕵️ Forensic Evidence Recovered!");
        System.out.println("Plaintext Password: " + plaintext);
    }
}
