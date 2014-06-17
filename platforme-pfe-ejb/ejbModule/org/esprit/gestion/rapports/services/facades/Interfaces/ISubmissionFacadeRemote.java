package org.esprit.gestion.rapports.services.facades.Interfaces;

import java.util.List;

import javax.ejb.Remote;

import org.esprit.gestion.rapports.persistence.Administrator;
import org.esprit.gestion.rapports.persistence.SubmissionEvent;

@Remote
public interface ISubmissionFacadeRemote {
	
	public boolean sessionOpened();

	public List<SubmissionEvent> listAllSubmitEvent();
	
	public void createSubmitEvent(SubmissionEvent submitEvent, Administrator sender);
}
