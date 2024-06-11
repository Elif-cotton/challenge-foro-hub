package com.foro.forohub.controller;

import com.foro.forohub.domain.topico.DatosListadoTopico;
import com.foro.forohub.domain.topico.DatosRegistroTopico;
import com.foro.forohub.domain.topico.Topico;
import com.foro.forohub.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        topicoRepository.save(new Topico(datosRegistroTopico));
    }


    @GetMapping
    public Page<DatosListadoTopico> listadotopicos(@PageableDefault(size = 2) Pageable paginacion) {
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

}
