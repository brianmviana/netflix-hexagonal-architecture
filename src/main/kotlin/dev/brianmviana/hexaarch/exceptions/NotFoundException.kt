package dev.brianmviana.hexaarch.exceptions

class NotFoundException: RuntimeException {

    constructor(message: String) : super(message)
    constructor() : super("The requested resource could not be found.")

}
