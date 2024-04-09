package com.enumvalidate;
public class Color {
    private ColorStatus status;

    public enum ColorStatus {
        RED,
        BLUE,
        GREEN;
    }

    public Color(ColorStatus status) {
        this.status = status;
    }

    public boolean isGreen() {
        if (getStatus() == ColorStatus.GREEN){
            return true;
        }
        return false;
    }

    public boolean isRed() {
        if (getStatus() == ColorStatus.RED){
            return true;
        }
        return false   ;
    }

    public ColorStatus getStatus() {
        return status;
    }
}
