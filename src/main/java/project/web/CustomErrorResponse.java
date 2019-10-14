package project.web;

import lombok.Data;

@Data
public class CustomErrorResponse {
    private int status;
    private String error;
}
