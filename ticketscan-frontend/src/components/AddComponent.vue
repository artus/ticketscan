<template>
    <div id="add" class="margin-big">

        <div class="row padding">
            <h2>Add ticket</h2>
        </div>

        <div class="row card rounded padding-big">
            <form class="grow" v-on:submit.prevent="addTicket">
                <div class="form-group">
                    <label for="ticket-id">Ticket ID:</label>
                    <input id="ticket-id" v-model="userId" required>
                </div>

                <div class="row grow">
                    <div class="form-group grow">
                        <label for="ticket-firstname">First name:</label>
                        <input id="ticket-firstname" v-model="firstName" required>
                    </div>

                    <div class="form-group grow">
                        <label for="ticket-lastname">Last name:</label>
                        <input id="ticket-lastname" v-model="lastName" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="ticket-email">Email:</label>
                    <input id="ticket-email" v-model="email" required>
                </div>

                <input type="submit" class="button primary">

                <div class="form-group"></div>
            </form>
        </div>

    </div>
</template>

<script>
import { Ticket } from './../Ticket';
import { TicketService } from './../TicketService';

export default {    
    props: {
        ticketService:  {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            userId: "",
            firstName: "",
            lastName: "",
            email: "",
        }
    },
    methods: {
        addTicket() {
            let newTicket = new Ticket(undefined, this.userId, this.firstName, this.lastName, this.email, false);
            console.log(newTicket);
            this.ticketService.addTicket(newTicket);
        }
    }

}
</script>

<style>

</style>


