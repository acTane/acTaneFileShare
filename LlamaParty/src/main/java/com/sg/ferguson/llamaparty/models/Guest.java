/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ferguson.llamaparty.models;

import java.util.Objects;

/**
 *
 * @author mrmac
 */
public class Guest {
    private String guestName;
    private int llamas;
    private boolean confirmed;

    public Guest() {
    }

    public Guest(String guestName, int llamas, boolean confirmed) {
        this.guestName = guestName;
        this.llamas = llamas;
        this.confirmed = confirmed;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getLlamas() {
        return llamas;
    }

    public void setLlamas(int llamas) {
        this.llamas = llamas;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.guestName);
        hash = 97 * hash + this.llamas;
        hash = 97 * hash + (this.confirmed ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Guest other = (Guest) obj;
        if (this.llamas != other.llamas) {
            return false;
        }
        if (this.confirmed != other.confirmed) {
            return false;
        }
        if (!Objects.equals(this.guestName, other.guestName)) {
            return false;
        }
        return true;
    }
    
    
    
}
