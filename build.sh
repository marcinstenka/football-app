# Windows-compatible script using Git Bash

function main() {
    cd ./football-app-player && ./build.sh && cd ..
    cd ./football-app-club && ./build.sh && cd ..
    cd ./football-app-gateway && ./build.sh && cd ..
    cd ./football-app-ng && ./build.sh && cd ..

     read -p "Press Enter to continue..."
}

main "$@"