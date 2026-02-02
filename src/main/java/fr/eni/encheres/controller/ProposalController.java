//package fr.eni.encheres.controller;
//
//import fr.eni.encheres.entity.Proposal;
//import fr.eni.encheres.service.ProposalService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class ProposalController {
//
//    private final ProposalService proposalService;
//
//    public ProposalController(ProposalService proposalService) {
//        this.proposalService = proposalService;
//    }
//
//    @PostMapping("/article/{id}/addProposal")
//    public String addProposal(@PathVariable("id") long id_article,@ModelAttribute Proposal proposal) {
//        System.out.println("proposal: " + proposal + " id: " + id_article);
//        proposalService.createProposal(proposal,id_article);
//        return "redirect:/mes-encheres";
//    }
////
//
//}
