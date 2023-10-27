package marcin.stenka.footballapp;

import marcin.stenka.footballapp.club.Club;
import marcin.stenka.footballapp.player.Player;
import marcin.stenka.footballapp.player.PlayerDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FootballAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballAppApplication.class, args);

//		Club barcelona = Club.builder().id(UUID.randomUUID()).name("Barcelona").foundingYear(1899).build();
//		Club realMadrid = Club.builder().id(UUID.randomUUID()).name("Real Madrid").foundingYear(1902).build();
//		Club liverpool = Club.builder().id(UUID.randomUUID()).name("Liverpool").foundingYear(1892).build();
//		Player player1 = Player.builder().id(UUID.randomUUID()).name("Robert").surname("Lewandowski").age(33).club(barcelona).build();
//		Player player2 = Player.builder().id(UUID.randomUUID()).name("Ronald").surname("Araujo").age(24).club(barcelona).build();
//		Player player3 = Player.builder().id(UUID.randomUUID()).name("Vinicius").surname("Junior").age(23).club(realMadrid).build();
//		Player player4 = Player.builder().id(UUID.randomUUID()).name("Virgil").surname("Van Dijk").age(32).club(liverpool).build();
//
//		Set<Player> allPlayers = Stream.of(barcelona, realMadrid, liverpool)
//				.flatMap(club -> club.getPlayers().stream())
//				.collect(Collectors.toSet());
//
//		System.out.println("WSZYSCY");
//		System.out.println(allPlayers);
//
//		List<Player> filteredAndSortedPlayers = allPlayers.stream()
//				.filter(player -> player.getAge() > 30)
//				.sorted(Comparator.comparing(Player::getSurname))
//				.collect(Collectors.toList());
//		System.out.println("SORTED");
//		System.out.println(filteredAndSortedPlayers);
//
//
//		List<PlayerDto> playerDtoList = allPlayers.stream()
//				.map(Player::toDto)
//				.sorted(Comparator.naturalOrder())
//				.collect(Collectors.toList());
//		System.out.println("DTO");
//		System.out.println(playerDtoList);
//
//
//		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clubs.ser"))) {
//			out.writeObject(List.of(barcelona, realMadrid, liverpool));
//			System.out.println("Clubs serialized and saved to 'clubs.ser'");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("DESERIALIZACJA");
//		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clubs.ser"))) {
//			List<Club> deserializedClubs = (List<Club>) in.readObject();
//
//
//			if (deserializedClubs != null) {
//				for (Club club : deserializedClubs) {
//					System.out.println(club.getName());
//					for (Player player : club.getPlayers()) {
//						System.out.println("- " + player.getName());
//					}
//				}
//			}
//		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		List<Club> clubs = Arrays.asList(barcelona, realMadrid, liverpool);
//
//		int[] poolSizes = {2, 4};
//		System.out.println("POOL");
//		for (int poolSize : poolSizes) {
//			ForkJoinPool customPool = new ForkJoinPool(poolSize);
//
//			System.out.println("Pool Size: " + poolSize);
//
//			customPool.submit(() -> clubs.parallelStream().forEach(category -> {
//				System.out.println("Club: " + category.getName());
//				category.getPlayers().forEach(player -> {
//					System.out.println("- Player: " + player.getSurname());
//					try {
//						TimeUnit.SECONDS.sleep(1);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				});
//			}));
//
//			customPool.shutdown();
//			try {
//				customPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
