package com.company.capstoneproject.controller;

import com.company.capstoneproject.service.ServiceLayer;
import com.company.capstoneproject.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/invoice")
    public List<InvoiceViewModel> getInvoices() {
        //need to create this method in service layer
        return serviceLayer.findAllInvoices();
    }

    @GetMapping("/invoice/{id}")
    public InvoiceViewModel getInvoiceById(@PathVariable int id) {
        //need to create this method in service layer
        return serviceLayer.findInvoice(id);
    }

    @GetMapping("/invoice/name/{name}")
    public InvoiceViewModel getInvoiceByName(@PathVariable String name) {
        //need to create this method in service layer
        return serviceLayer.findInvoiceByName(name);
    }

    @PostMapping("/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel albumViewModel) {
        //need to create this method in service layer
        return serviceLayer.saveInvoice(albumViewModel);
    }

    @PostMapping("/invoice/price")
    @ResponseStatus(HttpStatus.CREATED)
    public BigDecimal getUnitPrice(@RequestBody @Valid InvoiceViewModel viewModel) {
        //need to create this method in service layer
        return serviceLayer.GetUnitPrice(viewModel.getItem_type(), viewModel.getItem_id(), viewModel.getQuantity());
    }
}
