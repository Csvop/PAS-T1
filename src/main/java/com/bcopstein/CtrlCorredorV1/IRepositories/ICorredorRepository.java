package com.bcopstein.CtrlCorredorV1.IRepositories;

import java.util.*;

import com.bcopstein.CtrlCorredorV1.Models.Corredor;

public interface ICorredorRepository {
    public List<Corredor> consultaCorredores();
    public boolean cadastraCorredor(Corredor corredor);
}
