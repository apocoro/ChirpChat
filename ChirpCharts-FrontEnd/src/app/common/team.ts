export class Team {

    constructor(
        public id: number,
        public franchiseID: number,
        public teamName: string,
        public year: string,
        public wins: number,
        public losses: number,
        public overTimeWins: number,
        public lastUpdated: Date

    ) {}

}
