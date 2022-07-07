package com.eacuamba.project.jsf.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Named
@SessionScoped
public class UtilizadorBean implements Serializable {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private LocalDateTime loginDateTime;

    public boolean isLogado(){
        return Objects.nonNull(this.username);
    }
}
