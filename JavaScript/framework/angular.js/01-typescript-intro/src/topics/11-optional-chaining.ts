export interface Passenger {
    name: string;
    children?: string[];
}

const passenger1: Passenger = {
    name: 'Rigo',
}

const passenger2: Passenger = {
    name: 'Yira',
    children: ['Monica','Rigucci'],
}

const returnChildrenNumber = ( passenger: Passenger ): number => {

    const howManyChildren = passenger.children?.length || 0; //Si no existe retorna 0
    //const howManyChildren = passenger.children!.length;

    console.log( passenger.name, howManyChildren);

    return howManyChildren;
}


returnChildrenNumber( passenger1 );