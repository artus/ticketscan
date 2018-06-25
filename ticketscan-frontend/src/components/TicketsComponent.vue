<template>
    <div class="margin-big">

        <div class="row padding">
            <h2>All tickets</h2>
        </div>

        <div id="ticket-table" class="column margin card rounded">
            <div class="row grow padding-small vertical-center space-between" :key="index" v-for="(ticket, index) of tickets">
                <div>{{ticket.userId}}</div>
                <div>{{ticket.firstName}}</div>
                <div>{{ticket.lastName}}</div>
                <div>{{ticket.email}}</div>
                <div>{{ticket.scanned}}</div>
                <div class="button secondary" @click="scanTicket(ticket.userId)">scan</div>
                <div class="button danger" @click="deleteTicket(ticket.userId)">delete</div>
            </div>
        </div>

    </div>
</template>

<script>
export default {
    props: {
        ticketService: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            tickets: [],
        }
    },
    mounted() {
        this.refreshTickets();
   },
    methods: {
        refreshTickets() {
            console.log("Updating tickets...");
            this.ticketService.getTickets(response => {
                this.tickets.length = 0;
                for (let ticket of response) this.tickets.push(ticket);
            });
        },
        scanTicket(id) {
            this.ticketService.scanTicket(id, (function() { this.refreshTickets(); }).bind(this));
        },
        deleteTicket(id) {
            this.ticketService.deleteTicket(id, (function() { this.refreshTickets(); }).bind(this));
        }
    }

}
</script>

<style>
#ticket-table:nth-child(even) {
    background-color: lightblue;
}
</style>


