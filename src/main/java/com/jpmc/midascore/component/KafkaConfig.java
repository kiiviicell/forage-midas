@Bean
public ConsumerFactory<String, Transaction> consumerFactory() {

    JsonDeserializer<Transaction> deserializer =
            new JsonDeserializer<>(Transaction.class);
    deserializer.addTrustedPackages("*");

    Map<String, Object> props = new HashMap<>();

    props.put("bootstrap.servers", "localhost:9092");
    props.put("group.id", "midas");
    props.put("auto.offset.reset", "earliest");

    return new DefaultKafkaConsumerFactory<>(
            props,
            new StringDeserializer(),
            deserializer
    );
}
