export class Ticket {

    constructor(id, userId, firstName, lastName, email, scanned) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        typeof scanned == "undefined" ? this.scanned = true : this.scanned = scanned;
    }

}