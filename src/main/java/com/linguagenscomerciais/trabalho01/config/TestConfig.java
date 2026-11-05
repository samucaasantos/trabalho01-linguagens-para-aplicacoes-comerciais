package com.linguagenscomerciais.trabalho01.config;

import com.linguagenscomerciais.trabalho01.models.SupportTicket;
import com.linguagenscomerciais.trabalho01.models.enums.Priority;
import com.linguagenscomerciais.trabalho01.models.enums.Status;
import com.linguagenscomerciais.trabalho01.repositories.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    @Override
    public void run(String... args) throws Exception {
        SupportTicket t1 = new SupportTicket(null, "Impressora não imprime boletos", "Carlos Silva", "Financeiro", Priority.ALTA, Status.ABERTO);
        SupportTicket t2 = new SupportTicket(null, "Erro ao fechar folha de pagamento", "Ana Souza", "RH", Priority.ALTA, Status.EM_ANDAMENTO);
        SupportTicket t3 = new SupportTicket(null, "Troca de mouse com defeito", "Marcos Oliveira", "Comercial", Priority.BAIXA, Status.RESOLVIDO);
        SupportTicket t4 = new SupportTicket(null, "Queda de conexão com o servidor principal", "Roberto Lima", "TI", Priority.ALTA, Status.ABERTO);
        SupportTicket t5 = new SupportTicket(null, "Instalação de pacote Office", "Fernanda Costa", "Financeiro", Priority.MEDIA, Status.EM_ANDAMENTO);
        SupportTicket t6 = new SupportTicket(null, "Impressora sem toner no andar térreo", "Juliana Mendes", "Logística", Priority.MEDIA, Status.ABERTO);
        SupportTicket t7 = new SupportTicket(null, "Criação de e-mail para novo colaborador", "Patrícia Gomes", "RH", Priority.BAIXA, Status.ABERTO);
        SupportTicket t8 = new SupportTicket(null, "Sistema ERP travando na emissão de nota", "Lucas Martins", "Financeiro", Priority.ALTA, Status.RESOLVIDO);
        SupportTicket t9 = new SupportTicket(null, "Atualização de antivírus nas máquinas", "Diego Rocha", "TI", Priority.MEDIA, Status.RESOLVIDO);
        SupportTicket t10 = new SupportTicket(null, "Configuração de VPN para acesso remoto", "Camila Ferreira", "Comercial", Priority.MEDIA, Status.EM_ANDAMENTO);

        supportTicketRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10));
    }
}
