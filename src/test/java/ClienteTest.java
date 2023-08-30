import br.edu.ifpb.ads.dao.ClienteDaoImpl;
import br.edu.ifpb.ads.entities.Cliente;
import br.edu.ifpb.ads.entities.Endereco;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private ClienteDaoImpl clienteDao;

    @BeforeEach
    public void setUp() {
        clienteDao = new ClienteDaoImpl();
    }


    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("John Doe");
        cliente.setDataNascimento(LocalDate.of(1990, 1, 1));
        cliente.setEmail("john@example.com");
        cliente.setTelefone("1234567890");
        Endereco endereco = new Endereco(
                "Rua dos bobos",
                "Bairro dos bobos",
                379,
                "Estado dos bobos",
                "12345678", "Cidade dos bobos",
                "PB");
        cliente.setEndereco(endereco);

        assertDoesNotThrow(() -> {
            clienteDao.salvar(cliente);
        });
    }


    @Test
    public void testUpdateCliente() {
        Cliente cliente = clienteDao.pesquisar(1);
        // Update cliente properties
        cliente.setNome("Jane Doe");
        cliente.setEmail("jane@example.com");

        assertDoesNotThrow(() -> {
            clienteDao.atualizar(cliente);
        });
    }

    @Test
    public void testDeletarCliente() {
        Cliente cliente = clienteDao.pesquisar(1);
        assertDoesNotThrow(() -> {
            clienteDao.deletar(cliente);
        });
    }

    @Test
    public void testPesquisarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("John Doe");
        cliente.setDataNascimento(LocalDate.of(1990, 1, 1));
        cliente.setEmail("john@example.com");
        cliente.setTelefone("1234567");
        Endereco endereco = new Endereco(
                "Rua dos bobos",
                "Bairro dos bobos",
                379,
                "Estado dos bobos",
                "12345678", "Cidade dos bobos",
                "PB");
        cliente.setEndereco(endereco);
        // Save the cliente
        clienteDao.salvar(cliente);

        Long clientId = cliente.getId();

        Cliente clientePesquisado = clienteDao.pesquisar(clientId);

        assertNotNull(clientePesquisado);
        assertEquals(clientId, clientePesquisado.getId());
    }




}
