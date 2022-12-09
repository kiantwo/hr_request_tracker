package com.example.hr_request_tracker.hr_request_tracker.csv.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.IAgingTicket;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.ITicketCount;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.IUserCount;
import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;
import com.example.hr_request_tracker.hr_request_tracker.ticket.repository.ITicketRepository;

@Component
public class CsvExportService {
	@Autowired
	private ITicketRepository repository;
	
	public void writeAllTicketsToCsv(Writer writer) throws IOException {
		List<Ticket> tickets = repository.findAll();
		
		try(CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			for(Ticket ticket: tickets) {
				csvPrinter.printRecord(ticket.getTicketID(), 
						ticket.getAssignee().getUserID(), 
						ticket.getTracker().getTypeName(),
						ticket.getStatus().getStatusName(),
						ticket.getSubject(),
						ticket.getDescription(),
						ticket.getFile() != null ? ticket.getFile().getFileName() : "",
						ticket.getCreatedAt()
				);
			}
		} catch(IOException e) {
			System.out.println("Error while writing CSV " + e);
		}
	}
	
	public void writeAgingCategoryToCsv(Writer writer) throws IOException {
		List<IAgingTicket> tickets = repository.findByAgingCategory();
		
		try(CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			for(IAgingTicket ticket : tickets) {
				csvPrinter.printRecord(
						ticket.getTicketID(), ticket.getTracker().getTypeName(), 
						ticket.getStatus().getStatusName(), ticket.getSubject(),
						ticket.getAssignee().getUserFName(), ticket.getAssignee().getUserLName(),
						ticket.getCreatedAt()
				);
			}
		} catch(IOException e) {
			System.out.println("Error while writing CSV " + e);
		}
	}
	
	public void writeCountCategoryToCsv(Writer writer) throws IOException {
		List<ITicketCount> tickets = repository.findByCountCategory();
		
		try(CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			for(ITicketCount ticket: tickets) {
				csvPrinter.printRecord(ticket.getTracker().getTypeName(), ticket.getTrackerCount());
			}
		} catch(IOException e) {
			System.out.println("Error while writing CSV " + e);
		}
	}
	
	public void writeCountUserToCsv(Writer writer) throws IOException {
		List<IUserCount> users = repository.findByCountUser();
		
		try(CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			for(IUserCount user: users) {
				csvPrinter.printRecord(user.getUser().getUserID(), user.getUserCount());
			}
		} catch(IOException e) {
			System.out.println("Error while writing CSV " + e);
		}
	}
}
