package fr.eni.encheres.controller.converter;

import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.service.ProposalService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProposalConverter implements Converter<String, Proposal> {
    ProposalService proposalService;

    public ProposalConverter(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @Override
    public Proposal convert(String idProposal) {
        if (idProposal == null || idProposal.isBlank()) {
            return null;
        }
        Long id = Long.parseLong(idProposal);
        return proposalService.readById(id);
    }
}
