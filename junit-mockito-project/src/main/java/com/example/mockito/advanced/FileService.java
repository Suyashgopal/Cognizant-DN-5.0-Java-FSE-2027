package com.example.mockito.advanced;

public class FileService {
    private FileHandler handler;

    public FileService(FileHandler handler) {
        this.handler = handler;
    }

    public String readAndProcess(String path) {
        if (handler.exists(path)) {
            String content = handler.readFile(path);
            return "Processed " + content;
        }
        return "File not found";
    }

    public void saveFile(String path, String content) {
        handler.writeFile(path, content);
    }
}
