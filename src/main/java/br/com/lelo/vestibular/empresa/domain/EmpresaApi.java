package br.com.lelo.vestibular.empresa.domain;

import br.com.lelo.vestibular.empresa.service.EmpresaQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaApi {

    private EmpresaQueryService query;

    @Autowired
    public EmpresaApi(EmpresaQueryService query) {
        this.query = query;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/empresas/")
    public Iterable<Empresa> list() {
        return query.empresasFindAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/api/empresas/{codigoEmpresa}")
    public Iterable<Empresa> findByCodigo(@RequestParam(value = "codigoEmpresa") Long codigoEmpresa) {
        return query.empresasFindByCodigo(codigoEmpresa);
    }

}
