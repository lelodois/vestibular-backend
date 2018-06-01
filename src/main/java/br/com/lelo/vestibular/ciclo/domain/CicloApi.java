package br.com.lelo.vestibular.ciclo.domain;

import br.com.lelo.vestibular.ciclo.service.CicloCommandService;
import br.com.lelo.vestibular.ciclo.service.CicloQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CicloApi {

    @Autowired
    private CicloCommandService command;


    @Autowired
    private CicloQueryService query;

    @PostMapping("/api/ciclos/")
    public Ciclo novo(@Valid @RequestBody Ciclo task) throws Exception {
        return command.save(task);
    }

    @GetMapping(value = "/api/ciclos/empresa/{codigoEmpresa}")
    public Iterable<Ciclo> findByEmpresa(@RequestParam(value = "codigoEmpresa") Long codigoEmpresa) throws Exception {
        return query.ciclosFindByCodigoEmpresa(codigoEmpresa);
    }

}
