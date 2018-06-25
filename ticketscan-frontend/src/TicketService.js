import { Ticket } from './Ticket';

const axios = require('axios');

export class TicketService {
    
    constructor(url) {
        this.url = url;
    }

    getTickets(callback) {
        axios.get(this.url + "/ticket/").then(response => {
            callback(response.data);
        });
    }

    scanTicket(id, callback) {
        axios.post(this.url + "/ticket/" + id)
        .then(response => callback(response.data))
        .catch(response => alert("Ticket was already scanned! NO ENTRANCE"));
    }

    addTicket(ticket, callback) {
        axios.post(this.url + "/ticket/", ticket)
        .then(response => alert("Ticket added!"));
    }

    deleteTicket(ticketId, callback) {
        axios.delete(this.url + "/ticket/" + ticketId)
        .then(response => {
            console.log(response);
            callback()
        });
    }
}