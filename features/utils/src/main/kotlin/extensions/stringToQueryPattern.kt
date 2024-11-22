package extensions

fun String.toQuery():String{
    return if (this.isEmpty()){
        "%"
    }else{
        "%${this}%"
    }
}