const newAnonymousUsers = [];

db.collectionB.find({}).forEach(function (docFromB) {
    if (docFromB.children && typeof docFromB.children === 'object') {
        const childNames = Object.keys(docFromB.children);

        childNames.forEach(function (name) {
            const newUser = {
                name: "anonymous",
                lastname: "anonymous",
                username: "anonymous",
                email: "anonymous@anonymous",
                password: "anonymous",
                child: name,
                createdAt: new Date()
            };
            newAnonymousUsers.push(newUser);
            print(`📝 Prepared user for child: ${name}`);
        });
    } else {
        print(`⚠️ Skipping document with _id: ${docFromB._id} because it has no 'children' field.`);
    }
});

if (newAnonymousUsers.length > 0) {
    print(`\n⏳ Inserting ${newAnonymousUsers.length} new documents into collectionA...`);
    const result = db.collectionA.insertMany(newAnonymousUsers);
    print(`✅ Success! Inserted ${result.insertedIds.length} documents. Should be 10`);
} else {
    print("🤷 No new users were created. Check if collectionB contains the correct data.");
}

print("\n🎉 Script finished!");
