package org.glsid.metier;

import java.util.List;

import org.glsid.entities.Client;

public interface ClientMetier {
	public Client saveClient(Client c);
	public List<Client>listClients();
}
