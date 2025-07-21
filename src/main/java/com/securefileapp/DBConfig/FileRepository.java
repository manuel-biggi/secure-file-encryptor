package com.securefileapp.DBConfig;

import com.securefileapp.config.DBConfig;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FileRepository {


    public void saveFile(String name, String type, String hash, byte[] encryptedContent) throws Exception {
        try (Connection conn = DBConfig.getConnection()) {
            String sql = "INSERT INTO encrypted_files (name, type, hash, content) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, type);
                stmt.setString(3, hash);
                stmt.setBytes(4, encryptedContent);
                stmt.executeUpdate();
            }
        }
    }



}

