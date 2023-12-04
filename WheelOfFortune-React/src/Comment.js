import React, {useContext , useState, useEffect } from 'react';
import { CommentGameContext } from './App';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Comment(){
    const navigate = useNavigate();
    const {commentGameRecord,setCommentGameRecord} = useContext(CommentGameContext);
    const[newComment,setNewComment] = useState("");
    const[comments, setComments] = useState([]);

    //Function to save the game to the backend
    async function handleCreatPlayerName(event) {
        event.preventDefault();

        //Dta to be sent in the POST request
        const postData = {
            gameId:commentGameRecord.id,
            playerName: commentGameRecord.playerName,
            content:newComment
        };
        console.log(postData);
        try {
            //Save the user data
            const response = await axios.post('https://skilful-grove-404519.ue.r.appspot.com/saveComment', postData);
            console.log('Response:', response.data);
            findByGameId();
            
        } catch (error) {
            console.error('Error posting data:', error);
            alert("save failed")
        }
 
    };
    function findByGameId(){
         axios.get(`https://skilful-grove-404519.ue.r.appspot.com/findByGameId?gameId=${commentGameRecord.id}`)
        .then(response => {
          setComments(response.data);  // Axios packs the response in a 'data' property
        })
        .catch(error => {
          console.log(error.message);
        });    
    }
    function handlePlayGame(){
        navigate('/');
    }
useEffect(() => {
    findByGameId(); 
  }, [commentGameRecord]); 
    return (
        <div>
            <div className="display-comments">
                <div >
                    <h1>All Comments</h1>
                </div>
                {comments.map(comment => (
                    <div className="comment-item" key={comment.id}>
                       {comment.playerName} says: {comment.content} at {comment.date}
                    </div>
                ))}
            </div>
            <div className='create-new-comment'>
                <form onSubmit={handleCreatPlayerName}>
                <label className='comment-input-box'>
                Your comment:
                <textarea type="text" value={newComment} onChange={e => {
                        console.log(e.target.value);
                        setNewComment(e.target.value);
                        console.log(newComment);
                        }
                    } />
                </label>
                <button className='comment-Submit' type="submit">submit</button>
                </form>
            </div>
            <div >
                <button className="play-game-button-under-comment" onClick={handlePlayGame}>Play Game</button> 
            </div>
        </div>
      );
}

export default Comment;