rootProject.name = "confectionery-api"

include("app")

include("features:utils")
include("features:domain")
include("features:db")
include("features:repositories")
include("features:services")
include("features:handlers")

include("plugins:auth")
include("plugins:routing")
