package com.mathit.MathIt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.query.Criteria.where;

//Service for generating auto Increment ID for the database
@Service
public class SequenceGeneratorService {

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }
    public Integer generateSequence(String seqName){

        if(seqName.equals("profile_section")){
            Profile counter = mongoOperations.findAndModify(Query.query(
                    where("_id").is(seqName)
                    ), new Update().inc("seq",1),
                    FindAndModifyOptions.options()
                            .returnNew(true)
                            .upsert(true), Profile.class);
            return !Objects.isNull(counter) ? counter.getSeq() : 1;
        } else if(seqName.equals("user_section")){
            User counter = mongoOperations.findAndModify(Query.query(
                    where("_id").is(seqName)
                    ), new Update().inc("seq",1),
                    FindAndModifyOptions.options()
                            .returnNew(true)
                            .upsert(true), User.class);
            return !Objects.isNull(counter) ? counter.getSeq() : 1;
        }
        return 0;
    }
}
