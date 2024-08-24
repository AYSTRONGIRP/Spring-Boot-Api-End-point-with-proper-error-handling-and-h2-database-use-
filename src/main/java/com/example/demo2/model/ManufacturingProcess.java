package com.example.demo2.model;

public enum ManufacturingProcess {
    MOULDING("Moulding"),
    THREE_D_PRINTING("3D_PRINTING"),
    CASTING("Casting"),
    COATING("Coating");

    private final String displayName;

    ManufacturingProcess(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
